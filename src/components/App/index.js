import React, {Component} from 'react';
import {
    View,
    Text,
    StyleSheet,
    NativeModules
} from 'react-native';

import FirstPage from '../FirstPage';
import SecondPage from '../SecondPage';

const pages = {
  FirstPage,
  SecondPage
};

export default class App extends Component {
  render() {
    const Page = pages[this.props.page] || View;
    return (
        <Page onPageChange={this.props.onPageChange}/>
    )
  }
}

const styles = StyleSheet.create({
  wrap: {
    flex: 1
  }
});
