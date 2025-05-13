import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import API from '../api/api';
import { toast } from 'react-toastify';

const LoginPage = () => {
  const [form, setForm] = useState({ email: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const res = await API.post('/login', form);
      localStorage.setItem('user', JSON.stringify(res.data));
      toast.success('Welcome back!');
      // You can redirect to a dashboard here
    } catch (err: any) {
      toast.error(err.response?.data || 'Login failed');
    }
  };

  return (
    <div className="auth-container">
      <form className="auth-form" onSubmit={handleSubmit}>
        <h2>Login</h2>
        <input name="email" type="email" placeholder="Email" onChange={handleChange} required />
        <input name="password" type="password" placeholder="Password" onChange={handleChange} required />
        <button type="submit">Login</button>
        <p onClick={() => navigate('/signup')}>Don't have an account? Signup</p>
      </form>
    </div>
  );
};

export default LoginPage;
