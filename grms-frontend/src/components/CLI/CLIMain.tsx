import {Input} from "@nextui-org/react";
import { useState } from "react";
import axios from "axios";
import { GetTreeDrawer } from "../Drawers/GetTreeDrawer";
import { useUserStore } from "../../store/UserStore";



export const CLIMain = () =>{
    const [inputValue, setInputValue] = useState("");
    const[response,setResponse] = useState("");
    const backendUrl = import.meta.env.VITE_BACKEND_URL

     const {treeDrawerOpen , setTreeDrawerOpen} = useUserStore()
     const{treeRepoId , setTreeRepoId} = useUserStore()

    const handleKeyDown = (event:any) => {
        if (event.key === "Enter") {
          console.log(inputValue)
          handleCommand();
        }
      };

      const handleCommand = async() =>{

        const response = await axios.post(backendUrl+"/easyrepo/cli/execute", inputValue , {withCredentials: true , headers : {'X-CSRF-TOKEN': sessionStorage.getItem('csrf') }})
        setResponse(response?.data)
        if(response?.data.includes('tree')){
            setTreeDrawerOpen(true)
            setTreeRepoId(response?.data.split("=")[1])

        }
        console.log(response)

      }
    return(
        <>
        <div className="ml-4">
                <Input
          key={"sm"}
          className="max-w-[220px]"
          defaultValue=""
          label="Commander"
          placeholder="Type your CLI command"
          radius={"sm"}
          type="text"
          variant="underlined"
          onKeyDown={handleKeyDown}
          value={inputValue}
          onChange={(e) => setInputValue(e.target.value)}
        /> 
         </div>
         <div>
            {response}
            {response.includes('tree') && <GetTreeDrawer/> }

         </div>
        </>
    )
}