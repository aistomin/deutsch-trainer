import {createEntityAdapter, createSelector} from "@reduxjs/toolkit";
import {apiSlice} from "../api/apiSlice.jsx";

const adapter = createEntityAdapter({
    // todo: sort by meaningful part of the name
    sortComparer: (a, b) => b.id > a.id
});

const initialState = adapter.getInitialState();

export const vocabularySlice = apiSlice.injectEndpoints({
    endpoints: builder => ({
        getVocabularyItems: builder.query({
            query: () => '/vocabulary',
            transformResponse: data => {
                return adapter.setAll(initialState, data)
            },
            providesTags: (result, error, arg) => [
                {type: 'VocabularyItem', id: "LIST"},
                ...result.ids.map(id => ({type: 'VocabularyItem', id}))
            ]
        })
    })
});

const selectVocabularyResult = vocabularySlice.endpoints.getVocabularyItems.select();

const selectData = createSelector(
    selectVocabularyResult,
    result => result.data
);

export const {
    useGetVocabularyItemsQuery
} = vocabularySlice;

export const {
    selectAll: selectAllVocabularyItems,
} = adapter.getSelectors(state => selectData(state) ?? initialState);
