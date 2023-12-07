import {ref} from "vue";
import {defineStore} from "pinia";
export const userInfoStore = defineStore({
    id: 'userInfoStore', // unique id for the store
    state: () => ({
        account: {
            token: null
        },
    }),
    actions: {
        // You can use actions to perform asynchronous operations or to commit mutations
        setAccount(payload) {
            this.account.token = payload;
        },
    },
});