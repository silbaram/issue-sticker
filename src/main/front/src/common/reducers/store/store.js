import React, {createContext, useReducer} from "react";
import * as storeAction from "../action/action"

const initialTokenState = {
    isLogin: false,
    token: ''
}
const store = createContext(initialTokenState);
const {Provider} = store;

const StateProvider = ({children}) => {
    const [state, dispatch] = useReducer((state, action) => {
        switch (action.type) {
            case storeAction.TOKEN_RESET: {
                localStorage.setItem("userToken", "");
                return initialTokenState
            }
            case storeAction.SET_LOGIN_TOKEN: {
                localStorage.setItem("userToken", action.token);
                return { ...state, isLogin: true, token: action.token};
            }
            case storeAction.SET_LOGOUT_TOKEN: {
                localStorage.setItem("userToken", "");
                return { ...state, isLogin: false, token: ""};
            }
            default: {
                localStorage.setItem("userToken", "");
                throw new Error(`unexpected action.type: ${action.type}`);
            }
        };
    }, initialTokenState);

    return <Provider value={{state, dispatch}}>{children}</Provider>;
}

export {store, StateProvider}