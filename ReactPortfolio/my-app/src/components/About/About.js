import { Container, Image } from "react-bootstrap";

import mainLogo from "../../UI/profilepic.jpg";
const About = () => {
  return (
    <Container className="align-bottom">
      <Image roundedCircle="md" src={mainLogo} className="md-3"></Image>
      <p className="mt-3">
        After working in the Culinary field for over 9 years and seeking a new
        adventure, I found my passion in web development.
      </p>
    </Container>
  );
};

export default About;
