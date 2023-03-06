import React, {useState} from 'react';
import {selectAllVocabularyItems, useAddVocabularyItemMutation} from "./vocabularySlice.jsx";
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";

const NewVocabularyItem = () => {

    const [german, setGerman] = useState('');
    const [english, setEnglish] = useState('');
    const [pictureUrl, setPictureUrl] = useState('');

    const [addVocabularyItem] = useAddVocabularyItemMutation();

    const rows = useSelector(selectAllVocabularyItems)

    const navigate = useNavigate();

    const addItem = (e) => {
        e.preventDefault();
        addVocabularyItem({
            "german": german,
            "english": english,
            "pictureUrl": pictureUrl,
            "userId": 1
        });
        setGerman('');
        setEnglish('');
        setPictureUrl('');
        navigate('/vocabulary');
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
                <button
                    type="button"
                    onClick={addItem}
                >Add
                </button>
            </form>
        </section>
    );
};

export default NewVocabularyItem;
