import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {
    getAllCollections() {
        return http.get('/collections');
    },

    getPublicCollections() {
        return http.get('/collections/public');
    },

    getCollectionByUserId(userId) {
        return http.get(`/collections/user/${userId}`);
    },

    getCollectionById(collectionId) {
        return http.get(`/collections/${collectionId}`);
    },

    addCollection(collection, token) {
        const config = {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }
        }
        return http.post('collections/create', collection, config);
    },

    addComic(newComic, collectionId, token) {
        // const file = newComic.comic.image;
        // const formData = new FormData();
        // formData.append('file', file);
        const config = {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }
        }
        return http.post(`collections/${collectionId}`, newComic, config)
    },

    getComicsByCollectionId(collectionId) {
        return http.get(`/collections/${collectionId}/comics`);
    },

    getSuperheroCollectionStats(collectionId) {
        return http.get(`user/collection/${collectionId}/superhero`);
    },

    getPublisherCollectionStats(collectionId) {
        return http.get(`user/collection/${collectionId}/publisher`);
    },

    getSeriesCollectionStats(collectionId) {
        return http.get(`user/collection/${collectionId}/series`);
    }
}