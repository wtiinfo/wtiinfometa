import axios from 'axios';
import aliasIcon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './styles.css'

type Props = {
    saleId: number;
}

function handleClick(id: number) {
    axios(`${BASE_URL}/sales/${id}/notification-sms`)
        .then(response => {
            console.log("Mensagem enviada com sucesso")
        })
}

function NotificationButton({saleId}: Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={aliasIcon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton