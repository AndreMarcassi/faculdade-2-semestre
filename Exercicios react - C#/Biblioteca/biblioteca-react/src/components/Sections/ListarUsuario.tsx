import { Usuario } from "../../models/Usuario";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function ListarUsuario() {
    const [usuarios, setUsuarios] = useState<Usuario[]>([]);

    useEffect(() => {
        carregarUsuarios();
    }, []);

    function carregarUsuarios() {
        //FETCH ou AXIOS
        fetch("http://localhost:5098/api/usuario/listar")
            .then((resposta) => resposta.json())
            .then((usuarios: Usuario[]) => {
                console.table(usuarios);
                setUsuarios(usuarios);
            });
    }


    return (
        <div>

            {usuarios.map((usuario) => (
                <ul key={usuario.id}>

                    <li> ID: {usuario.id} </li>
                    <li> Nome: {usuario.nome} </li>
                    <br />

                </ul>
            ))}
            
        </div>
    );
}

export default ListarUsuario;