import React, {useState} from 'react';
import {
    selectVocabularyItemById,
    useUpdateVocabularyItemMutation
} from "./vocabularySlice.jsx";
import {useParams} from "react-router-dom";
import {useSelector} from "react-redux";

const NewVocabularyItem = () => {

    const {id} = useParams()

    const item = useSelector((state) => selectVocabularyItemById(state, Number(id)))

    const [german, setGerman] = useState(item?.german);
    const [english, setEnglish] = useState(item?.english);
    const [pictureUrl, setPictureUrl] = useState(item?.pictureUrl);
    const [example, setExample] = useState(item.example);

    const [updateVocabularyItem] = useUpdateVocabularyItemMutation();

    const addItem = (e) => {
        e.preventDefault();
        updateVocabularyItem({
            "id": item.id,
            "german": german,
            "english": english,
            "pictureUrl": pictureUrl,
            "example": example,
            "userId": 1
        });
    }

    return (
        <section>
            <form>
                <label htmlFor="german">German:</label>
                <input
                    type="text"
                    id="german"
                    name="german"
                    value={german}
                    onChange={e => setGerman(e.target.value)}
                />
                <label htmlFor="english">English:</label>
                <input
                    type="text"
                    id="english"
                    name="english"
                    value={english}
                    onChange={e => setEnglish(e.target.value)}
                />
                <label htmlFor="pictureUrl">Picture URL:</label>
                <input
                    type="text"
                    id="pictureUrl"
                    name="pictureUrl"
                    value={pictureUrl}
                    onChange={e => setPictureUrl(e.target.value)}
                />
                <label htmlFor="example">Example:</label>
                <input
                    type="text"
                    id="example"
                    name="example"
                    value={example}
                    onChange={e => setExample(e.target.value)}
                />
                <button
                    type="button"
                    onClick={addItem}
                >Save
                </button>
            </form>
        </section>
    );
};

export default NewVocabularyItem;
