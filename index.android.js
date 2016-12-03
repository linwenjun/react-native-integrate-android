import React, {Component} from 'react';
import {
    View,
    Text,
    AppRegistry,
    NativeModules
} from 'react-native';

import App from './src/components/App';

export default class AwesomeProject extends Component {
  constructor(props) {
    super(props);

    this.state = {
      page: 'pending'
    }
  }

  handlePageChange(page) {
    this.setState({
      page
    })
  }

  componentDidMount() {
    NativeModules.jnIntentModule.fetchProps((data)=> {
      this.setState({
        page: data
      });
    }, (err)=> {
      this.setState({
        page: 'error'
      });
    });
  }

  render() {
    return (
        <View style={{
          flex: 1
        }}>
          <App {...this.state} onPageChange={this.handlePageChange.bind(this)} />
        </View>
    );
  }
}

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);
