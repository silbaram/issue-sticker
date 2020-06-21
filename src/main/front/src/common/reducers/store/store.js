import React, { createContext, useReducer } from "react";
import * as storeAction from "../action/action"

const initialTokenState = {
    isLogin: sessionStorage.getItem("userisLogin") == null ? "" : sessionStorage.getItem("userisLogin"),
    token: sessionStorage.getItem("userToken") == null ? "" : sessionStorage.getItem("userToken")
}
const store = createContext(initialTokenState);
const { Provider } = store;

const StateProvider = ({children}) => {
    const [state, dispatch] = useReducer((state, action) => {
        switch (action.type) {
            case storeAction.TOKEN_RESET: {
                sessionStorage.setItem("userToken", "");
                sessionStorage.setItem("userisLogin", false);
                return initialTokenState
            }
            case storeAction.SET_LOGIN_TOKEN: {
                sessionStorage.setItem("userToken", action.token);
                sessionStorage.setItem("userisLogin", true);
                return { ...state, isLogin: true, token: action.token};
            }
            case storeAction.SET_LOGOUT_TOKEN: {
                sessionStorage.setItem("userToken", "");
                sessionStorage.setItem("userisLogin", false);
                return { ...state, isLogin: false, token: ""};
            }
            default: {
                sessionStorage.setItem("userToken", "");
                sessionStorage.setItem("userisLogin", false);
                throw new Error(`unexpected action.type: ${action.type}`);
            }
        };
    }, initialTokenState);

    return <Provider value={{state, dispatch}}>{children}</Provider>;
}

export {store, StateProvider}