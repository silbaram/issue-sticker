export const TOKEN_RESET = 'TOKEN_RESET';
export const SET_LOGIN_TOKEN = 'SET_LOGIN_TOKEN';
export const SET_IS_LOGIN = 'SET_IS_LOGIN';


export const initialTokenState = {
    isLogin: false,
    token: ''
}

export function tokenReducer(state, action) {

    switch (action.type) {
        case TOKEN_RESET: {
            return initialTokenState
        }
        case SET_IS_LOGIN: {
            return { ...state, isLogin: action.isLogin }
        }
        case SET_LOGIN_TOKEN: {
            return { ...state, isLogin: action.isLogin, token: action.token }
        }
        default: {
            throw new Error(`unexpected action.type: ${action.type}`)
        }
    }
}