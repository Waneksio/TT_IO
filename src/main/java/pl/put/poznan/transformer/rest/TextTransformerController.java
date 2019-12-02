package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

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

}


