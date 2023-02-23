import {Route, Routes} from "react-router-dom";
import Layout from "./components/Layout.jsx";
import Home from "./features/home/Home.jsx";
import Test from "./features/test/Test.jsx";
import Vocabulary from "./features/dictionary/Vocabulary.jsx";

function App() {

  return (
      <Routes>
        <Route path="/" element={<Layout/>}>
          <Route index element={<Home/>}/>
          <Route path="test">
            <Route index element={<Test/>}/>
          </Route>
            <Route path="vocabulary">
            <Route index element={<Vocabulary/>}/>
          </Route>
        </Route>
      </Routes>
  )
}

export default App
