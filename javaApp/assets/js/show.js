class Show extends React.PureComponent {
	constructor(props) {
		 super(props);
		this.state = {
			program_name: '',
			program_description: '',
			username: '',
			author: '',
			output: ''
			
		};
		this.clearData = this.clearData.bind(this);
		//this.handleTextInfo = this.handleTextInfo.bind(this);
}		
	componentDidMount() {
     axios.get('/Program/show/?id=data')
     .then((response) => {
		 console.log(response.data[0].program_name);
			this.setState({program_name: response.data[0].program_name,
						   program_description: response.data[0].program_description,
						   author: response.data[0].author,
						   username: response.data[0].username
							});
		})
       
  }
  	
	clearData() {
		
		var output = this.refs.output.getValue();
		if (output) {
			console.log(value);
			this.setState({output: null}); // <-- reset value
		}
		
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
				<font className = "fd">{this.state.program_name}</font>
				<div className="dropdown">
					<button className="dropbtn1"><img className="desc-img" src="/Asset/assets/?file=guest.png" alt="Guest" width="30" height="30" /><p id="desc-text">{this.state.username}</p></button>
						<div class="dropdown-content">
							<a href="/User/login/">
								<img className="desc-img6" src="/Asset/assets/?file=login.png" alt="Login" /><pre id="show">Login</pre></a>	
							<a  href="/Program/index/?order=ASC">
								<img className="desc-img7" src="/Asset/assets/?file=back.jpg" alt="Back" /><pre id="show">Home</pre></a>
							<a href="/Mailer/contact/contactPage">
								<img className="desc-img1" src="/Asset/assets/?file=contact.png" alt="Contact" /><pre id="show">Contact Us</pre></a>
							<a href="/User/signup/sign_up">
								<img className="desc-img8" src="/Asset/assets/?file=signup.png" alt="Signup" /><pre id="show">Signup</pre></a>
						</div>	
					</div>
				</div>	
			  		<div class="container">	
						<pre id="author">Author:</pre><h1>{this.state.author}</h1>
						<pre>{this.state.program_description}</pre>
						<form action="/Program/execute/?">
						<center>
							<textarea id="input" onClick ={() => this.clearData()} rows="10" cols="50" name="input" placeholder="Give the input">iinput</textarea>
							<input type="hidden" name="id" value= "intid" />
							<textarea id="output" rows="10" name="output"cols="50" onload="return false" placeholder="show output" ref="output" value={this.state.output}></textarea><br /><br /><br />
							<button id="button" type="submit" onclick="return stoppedType()">Submit</button>
							<button id = "co" onclick ="return stoppedTyping()">Compare</button>
						</center>
						</form>
					</div>
					
				<div class="footer">
					<p id="top">Ananth Kumar  Copyright&copy;2017</p>
					<br />
					<p id="move"></p>
					<div className="move-right">
						<div id="move-top">
							<a href = "https://www.facebook.com/cananthkumar" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=facebook.png" /></a>
							<a href = "https://plus.google.com/u/0/" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=googleplus.png" /></a>
							<a href = "https://www.linkedin.com/feed/" target = "_blank"><img className="footer-img" src = "/Asset/assets/?file=linkendin.png" /></a>
						</div>
					</div>
				</div>
		</div>		
		);
	}	
}
ReactDOM.render(
  <Show />,
  document.getElementById('showpage')
);
