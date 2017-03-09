import React, { Component } from 'react';
import './App.css';

var libraries = [];

class App extends Component {
    constructor(){
        super();
        this.fetchLibrary = this.fetchLibrary.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.state = {
            name: '',
            url: "",
            city: ""
        }
    }
    handleChange(event){
        this.setState({
            city: event.target.value
        })
    }
    fetchLibrary(){
        console.log('fetching...');
        fetch('https://api.kirjastot.fi/v3/organisation?city.name='+this.state.city)
        .then(result => result.json())
        .then(result => {
            libraries = [];
            for(var i = 0; i < result.items.length; i++){
                libraries.push({
                    name: result.items[i].name.fi, 
                    url: result.items[i].homepage.fi
                });
            }
            this.setState({asd: "asd"})
        })
        console.log(this.state.city);
    }
    
  render() {
    return (
      <div>
        <input type="text" value={this.state.value} onChange={this.handleChange} />
        Kaupunki
        <br/>
        <button onClick={this.fetchLibrary}>Send</button>
        <LibraryTable data={libraries} />
      </div>
    );
  }
}

// Component for library table
class LibraryTable extends Component {
  render() {    
   var rows = this.props.data.map(item =>
        <LibraryItem item={item}/>
    );

    return (
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>WWW</th>
          </tr>
        </thead>
        <tbody>{rows}</tbody>
      </table>
    );
  }
}

// Component for one table row
class LibraryItem extends Component {
  render() {
    return (
      <tr>
        <td>{this.props.item.name}</td>
        <td>{this.props.item.url}</td>
      </tr>);
  }
}

export default App;