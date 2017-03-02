import React, { Component } from 'react';
import './App.css';

class App extends Component {
    constructor(){
        super();
        this.fetchLibrary = this.fetchLibrary.bind(this);
        this.state = {
            name: '',
            url: "ff"
        }
    }
    fetchLibrary(){
        console.log('fetching...');
        fetch("https://api.kirjastot.fi/v3/organisation?city.name=Helsinki")
        .then(result => result.json())
        .then(result => this.setState({
                name: result.items[0].name.fi,
                url: result.items[0].homepage.fi,
            })
        );
    }
    
  render() {
    return (
      <div>
        <h1>Nimi: {this.state.name}</h1>
        <h1>Kotisivu: {this.state.url}</h1>
        <button onClick={this.fetchLibrary}>Send</button>
      </div>
    );
  }
}

// Component for student table
/*class Result extends Component {
  render() {    
   var rows = this.props.data.map(item =>
        <ResultItem item={item}/>
    );

    return (
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>{rows}</tbody>
      </table>
    );
  }
}

// Component for one table row
class ResultItem extends Component {
  render() {
    return (
      <tr>
        <td>{this.props.item.name}</td>
        <td>{this.props.item.email}</td>
      </tr>);
  }
}*/

export default App;