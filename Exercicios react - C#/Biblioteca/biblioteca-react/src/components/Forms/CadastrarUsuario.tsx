import { useEffect, useState } from "react";
import { Usuario } from "../../models/Usuario";
import './Login.css';
import { useNavigate } from "react-router-dom";

function CadastrarUsuario() {

    const [isVisible, setIsVisible] = useState(true);
    const navigate = useNavigate();

    const [nome, setNome] = useState("");
    const [cpf, setCpf] = useState("");
    const [telefone, setTelefone] = useState("");
    const [email, setEmail] = useState("");
    const [endereco, setEndreco] = useState("");
    const [senha, setSenha] = useState("");

    const closeLogin = () => {
        setIsVisible(false);
        navigate("/");
    };

    if (!isVisible) {
        return null;
    }

    function cadastrarUsuario(e: any) {

        const usuario: Usuario = {
            nome: nome,
            cpf: cpf,
            telefone: telefone,
            email: email,
            endereco: endereco,
            senha: senha
        };

        fetch(`http://localhost:5098/api/usuario/cadastrar`, {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(usuario),
          })
            .then((resposta) => {
                if (!resposta.ok) {
                    throw new Error("Erro ao cadastrar usuário.");
                }
                return resposta.json();
            })
            .then((usuario) => {
                navigate("/");
            })



        e.preventDefault();
        
    }
  
  
    return (

        <div className="fundo-login">
        
        <div className="login">
        
            <button className="close" onClick={closeLogin}> X </button> 
        
            <form className="flex" style={{flexWrap: 'wrap'}} onSubmit={cadastrarUsuario}>

                <input className="form-input" type="text" placeholder="nome" onChange={(e: any) => setNome(e.target.value)} required/>

                <input className="form-input" type="text" placeholder="Cpf" onChange={(e: any) => setCpf(e.target.value)} required/>

                <input className="form-input" type="text" placeholder="Telefone" onChange={(e: any) => setTelefone(e.target.value)}/>

                <input className="form-input" type="text" placeholder="Email" onChange={(e: any) => setEmail(e.target.value)}/>

                <input className="form-input" type="text" placeholder="Endereço" onChange={(e: any) => setEndreco(e.target.value)}/>

                <input className="form-input" type="text" placeholder="Senha" onChange={(e: any) => setSenha(e.target.value)} required/>

                <input className="form-input" type="submit" value="Confirmar"/>

            </form>
            
        </div>

    </div>
    
    );

}

export default CadastrarUsuario;