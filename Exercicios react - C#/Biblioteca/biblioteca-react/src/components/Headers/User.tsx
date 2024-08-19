import React, { useState, useEffect } from 'react';
import {useNavigate } from 'react-router-dom';
import './User.css';
import { Usuario } from '../../models/Usuario';

function User() {

    const [usuarioNome, setUsuarioNome] = useState<string | null>(null);
    const navigate = useNavigate();

    const handleNavigation = (path: string) => {
        navigate(path);
    };

    const handleLogout = () => {
        setUsuarioNome(null);
        localStorage.removeItem('usuarioID');
        navigate('/');
    };

    useEffect(() => {

        carregarUsuario();

        window.addEventListener('storage', handleStorageChange);
    
        return () => {
            window.removeEventListener('storage', handleStorageChange);
        };
        
    }, []);
    
    function handleStorageChange(event: StorageEvent) {
        carregarUsuario();
    }

    function carregarUsuario(){

        const usuarioID = localStorage.getItem('usuarioID');

        if (usuarioID) {
            
            fetch(`http://localhost:5098/api/usuario/buscar/${usuarioID}`)
                .then((resposta) => resposta.json())
                .then((nomeUsuario) => {
                    setUsuarioNome(nomeUsuario.nome ?? null);
                });

        }

    }

    if (!usuarioNome) {

        return <button className="butao flex" type="button" onClick={() => handleNavigation('/login')}>LOGIN</button>;

    }

    return usuarioNome === "ADM" ? (

        <div className="dropdown">

        <button className="butao-dropdown flex dropdown-toggle" type="button">ADM</button>

        <div className="dropdown-content">

            <button type="button" onClick={() => handleNavigation('/pagina-adm')}>Pagina de ADM</button>

            <button type="button" onClick={() => handleNavigation('/minhas-locacoes')}>Minhas locações</button>

            <button type="button" onClick={handleLogout}>Logout</button>

        </div>

        </div>

    ) : (

        <div className="dropdown">

        <button className="butao-dropdown flex dropdown-toggle" type="button">{usuarioNome}</button>

            <div className="dropdown-content" style={{ backgroundColor: '#f1f1f1' }}>

                <button type="button" onClick={() => handleNavigation('/minhas-locacoes')}>Minhas locações</button>

                <button type="button" onClick={handleLogout}>Logout</button>

            </div>

        </div>

    );

}

export default User;