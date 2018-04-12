class Index extends React.PureComponent {
	constructor(props) {
		 super(props);
		this.state = {
			data: [],
			order: 'ASC',
			number: 0,
			number1: 0,
			username: 'Guest'
			//username: Cookie.load('username')
		};
   	this.componentDidMount2 = this.componentDidMount2.bind(this);
	}
	componentDidMount() {
     axios.get('/Program/tableContent/?order=ASC&offset=0')
     .then((response) => {
			this.setState({data: response.data,
				username: response.data[1].username
				});
		})	
  }
  
 componentDidMount2(id) {
     axios.get('/Program/tableContent/?order=ASC&offset=' + id)
     .then((response) => {
			this.setState({data: response.data,
				username: response.data[1].username,
				number: id + 7,
				number1: id - 7
				});
		console.log(this.state.number);		
		})	
  }
  
	render() {
		if (this.state.username == null)
		{
			this.setState({ username: "Guest"})
		}
		return (
			<div>
				<div className="header">
					<font className = "fc">Java</font>
					<font className = "fd">List of Programs</font>
					<div className="dropdown">
						<button className="dropbtn"><a href="/"><img className="header-img" src = "/Asset/assets/?file=guest.png" alt="Guest" width="30" height="30"/></a><p id="user4">{this.state.username}</p></button>
							<div className="dropdown-content">
								<a href="/User/login/login">
									<img className="header-img2" src = "/Asset/assets/?file=login.png" alt="Login" /><pre id="head-button">Login</pre></a>						
								<a href="/Mail/contactUs/contact">
									<img className="header-img1" src = "/Asset/assets/?file=contact.png" alt="Contact" /><pre id="head-button">Contact</pre></a>						
								<a href="/User/signup/signup">
									<img className="header-img4" src = "/Asset/assets/?file=signup.png" alt="Signup" /><pre id="head-button">Signup</pre></a>						
							</div>
						</div>
					</div>
				<div className ="content">
					<center>
						<table id="results"  className="table" className= "tablesorter">
							<thead>
								<th>SerialNumber</th>
								<th onClick={() => this.componentDidMount2()}>ProgramName</th>
								<th>Action</th>
							</thead>
							<tbody>
								{this.state.data.map(function(item, key) {
									return (
										<tr key = {key}>
											<td>{key + 1}</td>
											<td>{item.program_name}</td>
											<td><a href = {'/Program/show/?id='+ item.id }><button>Go To Programs</button></a></td>
										</tr>
										)
								})}
							</tbody>
						</table>
					</center>
				</div>
				<div class="pagination">
					<center>
						<button id="onclick" onClick={() => this.componentDidMount2(this.state.number1)}>&laquo;</button>		
						<button onClick={() => this.componentDidMount2(0)}>1</button>
						<button onClick={() => this.componentDidMount2(7)}>2</button>
						<button onClick={() => this.componentDidMount2(14)}>3</button>
						<button onClick={() => this.componentDidMount2(21)}>4</button>
						<button id="onclick" onClick={() => this.componentDidMount2(this.state.number)}>&raquo;</button>	
					</center>	
				</div>	
			<div className="footer">
				<p id="top">Ananth Kumar  Copyright&copy; 2017</p>
				<br />
				<p id="move"></p>
				<div className="move-right">
					<div id="move-top">
						<a href = "https://www.facebook.com/cananthkumar" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=facebook.png" /></a>
						<a href = "https://plus.google.com/u/0/" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=googleplus.png" /></a>
						<a href = "https://www.linkedin.com/feed/" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=linkendin.png" /></a></div>
					</div>
				</div>	
			</div>			
		);
	}
}
ReactDOM.render(
  <Index />,
  document.getElementById('root')
);
