import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8081'
});

export default {
    getAllCollections() {
        return http.get('/collections');
    },

    getCollectionByUserId(userId) {
        return http.get(`/collections/user/${userId}`);
    },

    getCollectionById(collectionId) {
        return http.get(`/collections/${collectionId}`);
    }
}