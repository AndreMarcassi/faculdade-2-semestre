import { useEffect, useState } from "react";
import './ListarLocacoes.css';
import { Locacao } from "../../models/Locacao";

function ListarLocacoes() {
    const [locacoes, setLocacoes] = useState<Locacao[]>([]);

    useEffect(() => {
        carregarLocacoes();
    }, []);

    function carregarLocacoes() {
        const usuarioID = localStorage.getItem('usuarioID');
    
        if (usuarioID) {
            fetch(`http://localhost:5098/api/locacao/listar/${usuarioID}`)
                .then((resposta) => resposta.json())
                .then((data) => {
                    console.table('Dados carregados:', data);
                    if (Array.isArray(data)) {
                        setLocacoes(data);
                    } else {
                        console.error('Dados retornados não são um array:', data);
                    }
                })
                .catch(error => {
                    console.error('Erro ao carregar locações:', error);
                });
        }
    } 

    function devolucao(id: string) {
        fetch(`http://localhost:5098/api/locacao/devolver/${id}`, {
            method: 'DELETE',
        })
        .then((resposta) => {
            if (!resposta.ok) {
                throw new Error('Erro ao devolver locação');
            }
            console.log(`Locação ${id} devolvida com sucesso.`);
            carregarLocacoes();
        })
        .catch(error => {
            console.error('Erro ao devolver locação:', error);
        });
    }

    function formatarData(dataISO: string): string {
        return dataISO.split('T')[0];
    }

    return (

        <section className="flex borda-teste" style={{ flexWrap: 'wrap', justifyContent: 'space-evenly' }}>

            {locacoes.map(locacao => (

                <div className="locacao-div flex" key={locacao.id}>

                    <div className="locacao-capa2">

                        {locacao.livros && locacao.livros.length > 0 && (

                            <img src={locacao.livros[0].capa || ''} alt="capa do livro" />

                        )}

                    </div>

                    <div className="locacao-info flex">

                        {locacao.livros && locacao.livros.length > 0 ? (
                            <h3 className="locacao-titulo">{locacao.livros[0].titulo || 'Título não disponível'}</h3>
                        ) : (
                            <h3 className="locacao-titulo">Título não disponível</h3>
                        )}

                        <h3 className="locacao-locacao">Locação: {formatarData(locacao.dataEmprestimo) || 'Data não disponível'}</h3>
                        <h3 className="locacao-devolucao">Devolução: {formatarData(locacao.dataDevolucaoEsperada) || 'Data não disponível'}</h3>

                        <button className="butao-devolucao" type="button" onClick={() => devolucao(locacao.id)}>Devolução</button>

                    </div>

                </div>

            ))}

        </section>

    );

}

export default ListarLocacoes;