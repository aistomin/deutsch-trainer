import vocabularyReducer from '../features/vocabulary/vocabularySlice';
import {configureStore} from "@reduxjs/toolkit";

export const store = configureStore({
    reducer: {
        vocabulary: vocabularyReducer
    }
});
