import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Navigation from "./components/Navigation/Navigation";
import Projects from "./components/Projects/Projects";
import About from "./components/About/About";
import { Container, Row, Col } from "react-bootstrap";

function App() {
  return (
    <div className="App">
      <Navigation />

      <Container className="container-fluid">
        <Row>
          <Col className="py-5">
            <About />
          </Col>
          <Col className="py-5">
            <Projects />
          </Col>
        </Row>
      </Container>
    </div>
  );
}

export default App;
