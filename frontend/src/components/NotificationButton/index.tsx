import axios from 'axios';
import aliasIcon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../utils/request';
import './styles.css'
import { toast } from 'react-toastify'

type Props = {
    saleId: number;
}

function handleClick(id: number) {
    axios(`${BASE_URL}/sales/${id}/notification-sms`)
        .then(response => {
            toast.info("SMS enviado com sucesso")
        })
}

function NotificationButton({ saleId }: Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
            <img src={aliasIcon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton