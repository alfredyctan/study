//import Test from './welcome.js';


//function Welcome(props) {
//  return <h1>Hello, {props.name}</h1>;
//}


//var test = new Test();
//test.present();

class Welcome extends React.Component {
	render() {
		let _this = this.props;
		return <h1>Hello, {_this.name}</h1>;
	}
}

class Clock extends React.Component {

	constructor(props) {
		super(props);
		var esto = this;
		this.state = {
			date: new Date(),
			count: 0,
			interval: props.interval,
			increment: function () {
				console.log('increment');
				return esto.state.count++;
			}
		};
	}

	componentDidMount() {
		console.log("mount : " + this.state.interval);
		this.timerID = setInterval(
			() => this.tick(),
			this.state.interval
		);

		this.counterID = setInterval(
			() => this.increment(),
			0.5 * this.state.interval
		);
	}
	
	componentWillUnmount() {
		clearInterval(this.timerID);
		clearInterval(this.counterID);
	}

	render() {
		// let _this = this.props;
		//return <h2>It is {this.state.date.toLocaleTimeString()} - {this.state.increment()}.</h2>;
		return <h2>It is {this.state.date.toLocaleTimeString()} - {this.state.count}.</h2>;
	}

	tick() {
		this.setState(
			(oState, props) => ({
				date: new Date()
			})
		);
	}
	
	increment() {
		this.setState(
			(oState, props) => ({
				count: oState.count + 1
			})
		);
	}
}

class Toggle extends React.Component {
  constructor(props) {
    super(props);
    this.state = {isToggleOn: true};

    // This binding is necessary to make `this` work in the callback
    this.handleClick = this.handleClick.bind(this);
  }

  handleClick() {
    this.setState(prevState => ({
      isToggleOn: !prevState.isToggleOn
    }));
  }

  render() {
    return (
      <button onClick={this.handleClick}>
        {this.state.isToggleOn ? 'ON' : 'OFF'}
      </button>
    );
  }
}

class Everything extends React.Component {

	render() {
		let _this = this.props;
		return (
			<span>
				<Welcome name="Sara" />
				<Clock interval="1000" />
				<Clock interval="2000" />
				<Clock interval="3000" />
				<Toggle/>
			</span>
		);
	}
}

setInterval(
	function () {
		ReactDOM.render(
			<Everything />,
			document.getElementById('main')
		);
	},
	1000
);

class Button extends React.Component {

	onButtonClick(e) {
		// console.log('The button1 was clicked. ' + Object.keys(e));
		// console.log('The button1 was clicked. ');
	}


	render() {
		let _this = this.props;
		return <button className="btn" onClick={this.onButtonClick}>{_this.name}</button>;
	}
}


class Button2 extends React.Component {



	render() {
		let _this = this.props;
		console.log('The button render. ' + _this.listener);
		return <button className="btn" onClick={_this.listener}>{_this.name}</button>;
	}
}

function onButtonClickOMS(e) {
	console.log('The OMS button was clicked. ' + e);
}

function onButtonClickLCM(e) {
	console.log('The LCM button was clicked. ' + e);
}

class Menu extends React.Component {
	render() {
		let _this = this.props;
		return (
			<div>
				<Button name="POC" />
				<Button2 name="OMS" listener={onButtonClickOMS} />
				<Button2 name="LCM" listener={onButtonClickLCM} />
			</div>
		);
	}
}

ReactDOM.render(
	<Menu />,
	document.getElementById('menu')
);
