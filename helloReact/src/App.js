import React, { Component } from 'react';
import './App.css';

class App extends Component {
  constructor(props){
      super(props);
      this.state = {name: "", click: 0};
      this.handleChange = this.handleChange.bind(this);
      this.buttonClicked = this.buttonClicked.bind(this);
  }
    
    handleChange(event){
        this.setState({name: event.target.value});
    }
    buttonClicked(event){
        this.setState({click: this.state.click + 1});
    }
    
  render() {
    return (
        <div>
            <h1>Hei, {this.state.name}</h1>
            <h1>Painettu {this.state.click} kertaa</h1>
            <input type="text" onChange={this.handleChange} />
            <br/>
            <button type="button" onClick={this.buttonClicked}>Paina</button>
        </div>
    );
  }
}

export default App;
