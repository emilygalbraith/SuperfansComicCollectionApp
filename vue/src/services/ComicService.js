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
    },

    getTotalComics() {
        return http.get('statistics/totalComics');
    },

    getSuperheroStats() {
        return http.get('statistics/superhero');
    },

    getPublisherStats() {
        return http.get('statistics/publisher');
    },

    getSeriesStats() {
        return http.get('statistics/series');
    },

    getAllSuperheroes() {
        return http.get('superheroes');
    },

    getAllAvatarImgs() {
        return http.get('/profiles');
    },

    addUserProfile(userProfile, token) {
        const config = {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            }
        }
        return http.post('/user/profile', userProfile, config);
    },

    getProfileById(userId) {
        return http.get(`profile/user/${userId}`);
    }
}