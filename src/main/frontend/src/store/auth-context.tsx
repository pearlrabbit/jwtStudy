import React, { useState, useEffect, useCallback } from "react";
import * as authAction from './auth-action'; 

let logoutTimer: NodeJS.Timeout;

type Props = { children?: React.ReactNode }
type UserInfo = { username: string, nickname: string};
type LoginToken = { 
  grantType: string,
  accessToken: string,
  tokenExpiresIn: number
}

const AuthContext = React.createContext({
  token: '',
  userObj: { username: '', nickname: '' },
  isLoggedIn: false,
  isSuccess: false,
  isGetSuccess: false,
  signup: (username: string, password: string, nickname:string) =>  {},
  login: (username:string, password: string) => {},
  logout: () => {},
  getUser: () => {},
  changeNickname: (nickname:string) => {},
  changePassword: (exPassword: string, newPassword: string) => {}
});


export const AuthContextProvider:React.FC<Props> = (props) => {

  const tokenData = authAction.retrieveStoredToken();

  let initialToken:any;
  if (tokenData) {
    initialToken = tokenData.token!;
  }

  const [token, setToken] = useState(initialToken);
  const [userObj, setUserObj] = useState({
    username: '',
    nickname: ''
  });
  
  const [isSuccess, setIsSuccess] = useState<boolean>(false);
  const [isGetSuccess, setIsGetSuccess ] = useState<boolean>(false);

  const userIsLoggedIn = !!token;


  
  const signupHandler = (username:string, password: string, nickname: string) => {
    setIsSuccess(false);
    const response = authAction.signupActionHandler(username, password, nickname);
    response.then((result) => {
      if (result !== null) {
        
      }
    });
    setIsSuccess(true);
  }

  /*
  const loginHandler = (email:string, password: string) => {
    setIsSuccess(false);
    
    const data = authAction.loginActionHandler(email, password);
    data.then((result) => {
      if (result !== null) {
        const loginData:LoginToken = result.data;
        setToken(loginData.accessToken);
        logoutTimer = setTimeout(
          logoutHandler,
          authAction.loginTokenHandler(loginData.accessToken, loginData.tokenExpiresIn)
        );
        setIsSuccess(true);
      }
    })
  };
  */

  const loginHandler = async (username:string, password: string) => {
    setIsSuccess(false);
    const getData = await authAction.loginActionHandler(username, password);
    const loginData:LoginToken = getData?.data;
    if (loginData) {
      setToken(loginData.accessToken);
      logoutTimer = setTimeout(
        logoutHandler,
        authAction.loginTokenHandler(loginData.accessToken, loginData.tokenExpiresIn)
      );
    }
    setIsSuccess(true);
  };

  const logoutHandler = useCallback(() => {
    setToken('');
    authAction.logoutActionHandler();
    if (logoutTimer) {
      clearTimeout(logoutTimer);
    }
  }, []);

  const getUserHandler = () => {
    setIsGetSuccess(false);
    const data = authAction.getUserActionHandler(token);
    data.then((result) => {
      if (result !== null) {
        console.log('get user start!');
        const userData:UserInfo = result.data;
        setUserObj(userData);
        setIsGetSuccess(true);
      }
    })    
    
  };

  const changeNicknameHandler = (nickname:string) => {
    setIsSuccess(false);

    const data = authAction.changeNicknameActionHandler(nickname, token);
    data.then((result) => {
      if (result !== null) {
        const userData:UserInfo = result.data;
        setUserObj(userData);
        setIsSuccess(true);
      }
    })
  };

  const changePaswordHandler = (exPassword:string, newPassword: string) => {
    setIsSuccess(false);
    const data = authAction.changePasswordActionHandler(exPassword, newPassword, token);
    data.then((result) => {
      if (result !== null) {
        setIsSuccess(true);
        logoutHandler();
      }
    });
  };

  useEffect(() => {
    if(tokenData) {
      console.log(tokenData.duration);
      logoutTimer = setTimeout(logoutHandler, tokenData.duration);
    }
  }, [tokenData, logoutHandler]);


  const contextValue = {
    token,
    userObj,
    isLoggedIn: userIsLoggedIn,
    isSuccess,
    isGetSuccess,
    signup: signupHandler,
    login: loginHandler,
    logout: logoutHandler,
    getUser: getUserHandler,
    changeNickname: changeNicknameHandler,
    changePassword: changePaswordHandler
  }
  
  return(
    <AuthContext.Provider value={contextValue}>
      {props.children}
    </AuthContext.Provider>
  )
}

export default AuthContext;