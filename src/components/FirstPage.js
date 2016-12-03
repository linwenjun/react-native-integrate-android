import React, {Compoent} from 'react';
import {
    View,
    Text,
    StyleSheet,
    NativeModules
} from 'react-native';

const FirstPage = ({onPageChange})=> {
  return (
      <View style={styles.wrap}>
        <Text style={styles.text}>React Native 的第一个页面</Text>

        <Text style={styles.button} onPress={()=> {
                onPageChange('SecondPage')
              }}>
          去React Native第二个页面</Text>
        <Text style={styles.button} onPress={()=> {
          NativeModules.jnIntentModule.goNative('home');
        }}>去原生页面</Text>
      </View>
  )
};

const styles = StyleSheet.create({
  wrap: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#FFF'
  },
  text: {
    fontSize: 18
  },
  button: {
    backgroundColor: '#0CF',
    padding: 10,
    margin: 10,
    borderWidth: 1
  }
});

export default FirstPage;