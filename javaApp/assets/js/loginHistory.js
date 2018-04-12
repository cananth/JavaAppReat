class LoginHistory extends React.PureComponent {
	constructor(props) {
		 super(props);
		this.state = {
			data: [],
			username: ''
			};
	}	
	
	componentDidMount() {
     axios.get('/History/userHistory/?history=true')
     .then((response) => {
			this.setState({data: response.data,
						   username: response.data[0].username
						});
		})
       
  }
  
  render() {
		
		return (
			
			<div>
				<div className="header">
					<font className = "fc">Java</font>
					<font className = "fd">Login History</font>
					<div className="dropdown">
						<button className="dropbtn" onclick="document.getElementById('myModal').style.display='block';" style="width:auto;"><img class="header-img"src="/Asset/assets/?file=guest.png" /><p id="user">{this.state.username}</p></button>
						<div className="dropdown-content">
							<a onclick="goBack()" href="#">
								<img className="loghistory-img" src="/Asset/assets/?file=back.jpg" alt="Back" /><pre id="log-his">Back</pre></a>
							<a href="/Program/index/?order=ASC">
								<img className="loghistory-img" src="/Asset/assets/?file=home.png" alt="Home" /><pre id="log-his">Home</pre></a>
							<a href="/Mail/contactUs">
								<img className="loghistory-img" src="/Asset/assets/?file=contact.png" alt="Contact" /><pre id="log-his">Contact</pre></a>
							<a href="/User/logout/logout">
								<img className="loghistory-img" src="/Asset/assets/?file=logout.jpg" alt="Logout" /><pre id="log-his">Logout</pre></a>						
						</div>
					</div>
				</div>
			</div>
		
		)
	  
	}	  

}
ReactDom.render(
<LoginHistory />,
document.getElementById('loginhistory')
);
