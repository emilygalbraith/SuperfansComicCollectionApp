import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
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
    },

    addCollection(collection) {
        return http.post('collections/create', collection);
    },

    addComic(newComic, collectionId) {
        return http.post(`collections/${collectionId}`, newComic)
    }
}