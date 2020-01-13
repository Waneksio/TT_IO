package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    // Usuniecie powtorzen
    @RequestMapping(value = "/repetitionsremoved/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getRepetitionsRemoved(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new TextRepetitionsRemoved(new TextTransform()).transform(text);
    }

    // Rozwiniecie liczb na slowa
    @RequestMapping(value = "/numberexpand/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getNumberExpand(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new TextNumberExpand(new TextTransform()).transform(text);
    }

    // Rozwiniecie skrotow
    @RequestMapping(value = "/shortsexpand/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getShortsExpand(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new TextShortsExpand(new TextTransform()).transform(text);
    }

    // Zwiniecie slow do skrotow
    @RequestMapping(value = "/wordstoshorts/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getWordsToShorts(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new TextWordsToShorts(new TextTransform()).transform(text);
    }

    @RequestMapping(value = "/capitalize/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getCapitalize(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new Capitalizer(new TextTransform()).transform(text);
    }

    @RequestMapping(value = "/lower/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getLower(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new Lowerer(new TextTransform()).transform(text);
    }

    @RequestMapping(value = "/reverse/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getReverse(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new Reverser(new TextTransform()).transform(text);
    }

    @RequestMapping(value = "/transformSigns/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getSingsTransform(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new SignsConverter(new TextTransform()).transform(text);
    }

    @RequestMapping(value = "/upper/{text:.+}", method = RequestMethod.GET, produces = "application/json")
    public String getUper(@PathVariable String text) {
        // log the parameters
        logger.debug(text);

        // Return transformed text
        return new Upperer(new TextTransform()).transform(text);
    }
}


