import './header.css';
import User from './User';
import ListaParaLocar from './ListaParaLocar';
import { useNavigate } from 'react-router-dom';


function Header() {

    const navigate = useNavigate();

    const handleNavigation = (path: string) => {
        navigate(path);
    };

    return (

        <header className="flex borda-teste" style={{ justifyContent: 'space-between' }}>

            <div className="div-header flex">

                <h2 className="logo flex" onClick={() => handleNavigation('/')}> BIBLIOTECA REACT </h2>

            </div>

            <div className="div-header flex" style={{ justifyContent: 'space-between' }}>

                <ListaParaLocar/>

                <User />

            </div>

        </header>

    );

}
    
export default Header;
