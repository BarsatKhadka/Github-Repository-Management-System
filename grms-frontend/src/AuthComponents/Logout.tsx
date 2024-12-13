import axios from 'axios'
import { useNavigate } from 'react-router-dom'

export const Logout = () =>{

    const navigate = useNavigate()

    const logoutFunction = async() =>{
        try{
       await axios.post('http://localhost:8080/logout' , {}, {withCredentials: true , headers: {'X-CSRF-TOKEN' : sessionStorage.getItem('csrf')}})
       sessionStorage.removeItem('authenticated')
       navigate('/')
        }

        catch(error){

        }
    }

    return (
        <>
        <button onClick = {logoutFunction}>Logout </button>

        </>
    )
}