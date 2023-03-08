import {Route, Routes} from "react-router-dom";
import Layout from "./components/Layout.jsx";
import Home from "./features/home/Home.jsx";
import Test from "./features/test/Test.jsx";
import VocabularyTable from "./features/vocabulary/VocabularyTable.jsx";
import NewVocabularyItem from "./features/vocabulary/NewVocabularyItem.jsx";
import EditVocabularyItem from "./features/vocabulary/EditVocabularyItem.jsx";

function App() {

    return (
        <Routes>
            <Route path="/" element={<Layout/>}>
                <Route index element={<Home/>}/>
                <Route path="test">
                    <Route index element={<Test/>}/>
                </Route>
                <Route path="vocabulary">
                    <Route index element={<VocabularyTable/>}/>
                    <Route path="new" element={<NewVocabularyItem/>}/>
                    <Route path="edit/:id" element={<EditVocabularyItem/>}/>
                </Route>
            </Route>
        </Routes>
    )
}

export default App
