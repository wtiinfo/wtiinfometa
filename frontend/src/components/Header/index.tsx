import logotipo from '../../assets/img/logotipo.svg'
import './styles.css'

function Header() {
  return (
    <header>
        <div className="dsmeta-logo-container">
            <img src={logotipo} alt="Wtiinfo" />
            <h1>Wtiinfo</h1>
            <p>
              Desenvolvido por 
            <a href="https://github.com/wtiinfo"> Wando Borges</a>
            </p>
        </div>
    </header>
  )
}

export default Header