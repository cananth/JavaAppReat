export function goBack() {
    window.history.back();
}

export function clearData()
{
	
  document.getElementById('output').value = "";	
}


export function stoppedTyping(){
         if (document.getElementById('output').value == '')
          { 
            document.getElementById('message1').style.color = 'red';
            document.getElementById('message1').innerHTML = 'PLease give user output for compare';
            return false;
        } else if (document.getElementById('input').value == '')
        {
			document.getElementById('message1').style.color = 'red';
            document.getElementById('message1').innerHTML = 'PLease give  input for execute';
            return false;
            
		} else if ((document.getElementById('input').value == '') && (document.getElementById('output').value == ''))
		{
			document.getElementById('message1').style.color = 'red';
            document.getElementById('message1').innerHTML = 'PLease give  input for execute';
            return false;
		}
         
    }
    
    function stoppedType(){
         if (document.getElementById('input').value == '')
          { 
            document.getElementById('message1').style.color = 'red';
            document.getElementById('message1').innerHTML = 'PLease give  input for execute';
            return false;
        } 
    }
    
    
