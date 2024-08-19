import React from 'react';
import ReactDOM from 'react-dom/client';
import Header from './components/Headers/Header';
import Section from './components/Sections/Section'
import Login from './components/Forms/Login'
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CadastrarUsuario from './components/Forms/CadastrarUsuario';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>

    <Router>

        <Header />
        
        <Section/>

        <Routes>

            <Route path='/login' element={<Login />} />
            <Route path='/cadastrar' element={<CadastrarUsuario />} />

        </Routes>

    </Router>

  </React.StrictMode>
);