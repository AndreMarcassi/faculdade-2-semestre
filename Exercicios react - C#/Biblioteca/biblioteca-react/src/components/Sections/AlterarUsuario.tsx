    import { useEffect, useState } from "react";
    import { Usuario } from "../../models/Usuario";

    function AlterarUsuario(){

        const [id, setId] = useState("");

        const [telefone, setTelefone] = useState("");
        const [email, setEmail] = useState("");
        const [endereco, setEndreco] = useState("");
        const [senha, setSenha] = useState("");

        function AlterarUsuario(e: React.FormEvent<HTMLFormElement>) {
            e.preventDefault();
    
            const usuario: Partial<Usuario> = {};
    
            if (telefone !== "") {
                usuario.telefone = telefone;
            }
            if (email !== "") {
                usuario.email = email;
            }
            if (endereco !== "") {
                usuario.endereco = endereco;
            }
            if (senha !== "") {
                usuario.senha = senha;
            }
    
            if (Object.keys(usuario).length === 0) {
                alert("Nenhum campo preenchido para atualização.");
                return;
            }

            fetch(`http://localhost:5098/api/usuario/alterar/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(usuario),
            })
            .then((resposta) => {
                if (!resposta.ok) {
                    throw new Error('Erro ao alterar usuário');
                }
                return resposta.json();
            })
            .then((data) => {
                console.log("Usuário atualizado com sucesso:", data);
            })
            .catch((error) => {
                console.error("Erro ao atualizar usuário:", error);
            });
            

            e.preventDefault();

        }

        return (

            <form className="flex" style={{flexWrap: 'wrap'}} onSubmit={AlterarUsuario}>

                <input className="form-input" type="text" placeholder="id" onChange={(e) => setId(e.target.value)} required/>

                <input className="form-input" type="text" placeholder="Telefone" onChange={(e) => setTelefone(e.target.value)}/>

                <input className="form-input" type="text" placeholder="Email" onChange={(e) => setEmail(e.target.value)}/>

                <input className="form-input" type="text" placeholder="Endereço" onChange={(e) => setEndreco(e.target.value)}/>

                <input className="form-input" type="text" placeholder="Senha" onChange={(e) => setSenha(e.target.value)}/>

                <input className="form-input" type="submit" value="Confirmar"/>

            </form>

        );

    }

    export default AlterarUsuario;