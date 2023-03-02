import {createAsyncThunk, createEntityAdapter, createSlice} from "@reduxjs/toolkit";
import axios from "axios";

const API_URL = 'http://localhost:3004/vocabulary';

const adapter = createEntityAdapter({
    // todo: sort by meaningful part of the name
    sortComparer: (a, b) => b.id > a.id
});

const initialState = adapter.getInitialState({
    status: 'idle', //'idle' | 'loading' | 'succeeded' | 'failed'
    error: null
});

const vocabularySlice = createSlice({
    name: 'vocabulary',
    initialState,
    extraReducers(builder) {
        builder
            .addCase(fetchVocabulary.pending, (state, action) => {
                state.status = 'loading'
            })
            .addCase(fetchVocabulary.fulfilled, (state, action) => {
                state.status = 'succeeded'
                adapter.upsertMany(state, action.payload);
            })
            .addCase(fetchVocabulary.rejected, (state, action) => {
                state.status = 'failed'
                state.error = action.error.message
            })
    }
})

export const fetchVocabulary = createAsyncThunk('vocabulary/fetch', async () => {
    return (await axios.get(API_URL)).data
})

export const {
    selectAll: selectTheWholeVocabulary,
} = adapter.getSelectors(state => state.vocabulary);

export const getVocabularyStatus = (state) => state.vocabulary.status;

export const getVocabularyError = (state) => state.vocabulary.error;

export default vocabularySlice.reducer;
