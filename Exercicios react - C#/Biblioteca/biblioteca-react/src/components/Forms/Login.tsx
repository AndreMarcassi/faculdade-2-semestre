import { useEffect, useState } from 'react';
import { loginRequest } from '../../models/loginRequest';
import { useNavigate } from "react-router-dom";
import './Login.css';


function Login() {

    const [isVisible, setIsVisible] = useState(true);
    const [cpf, setCpf] = useState("");
    const [senha, setSenha] = useState("");
    const navigate = useNavigate();

    const [loading, setLoading] = useState(false);

    const handleNavigation = (path: string) => {
        navigate(path);
    };

    const closeLogin = () => {
        setIsVisible(false);
        navigate("/");
    };

    if (!isVisible) {
        return null;
    }

    function verificarUsuario(e: any) {

        e.preventDefault()
        
        const loginRequest : loginRequest = {
            Cpf : cpf,
            Senha : senha
          };
    
        fetch("http://localhost:5098/api/usuario/verificar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(loginRequest),
        })
        .then((resposta) => {
            if (!resposta.ok) {
                throw new Error("Erro ao verificar usuário.");
            }
            return resposta.json();
        })
        .then((usuario) => {
            localStorage.setItem('usuarioID', usuario.id);
            window.dispatchEvent(new Event('storage'));
            navigate("/");
        })
    }

    return (

        <div className="fundo-login">
        
            <div className="login">
            
                <button className="close" onClick={closeLogin}> X </button> 
            
                <form className="ajustar" onSubmit={verificarUsuario}>

                    <input className="form-login" type="text" name="cpf" placeholder="CPF" value={cpf} onChange={(e: any) => setCpf(e.target.value)}></input>
                    <input className="form-login" type="text" name="senha" placeholder="Senha" value={senha} onChange={(e: any) => setSenha(e.target.value)}></input>

                    <input className="form-login" style={{ backgroundColor: 'transparent'}} type="submit" disabled={loading}></input>

                </form>
                            
                <button className="buttom-new" type="button" onClick={() => handleNavigation('/cadastrar')}> Don't have an account? CREATE ONE </button>
                
            </div>

        </div>

    );

}

export default Login;
