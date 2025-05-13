import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import API from '../api/api';
import { toast } from 'react-toastify';

const SignupPage = () => {
  const [form, setForm] = useState({ username: '', email: '', password: '' });
  const navigate = useNavigate();

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await API.post('/users/register', form);
      toast.success('Signup successful! You can now login.');
      navigate('/users/login');
    } catch (err: any) {
      toast.error(err.response?.data || 'Signup failed');
    }
  };

  return (
    <div className="auth-container">
      <form className="auth-form" onSubmit={handleSubmit}>
        <h2>Signup</h2>
        <input name="username" placeholder="Username" onChange={handleChange} required />
        <input name="email" type="email" placeholder="Email" onChange={handleChange} required />
        <input name="password" type="password" placeholder="Password" onChange={handleChange} required />
        <button type="submit">Sign Up</button>
        <p onClick={() => navigate('/login')}>Already have an account? Login</p>
      </form>
    </div>
  );
};

export default SignupPage;
