//import static com.tutego.jrtf.Rtf.document;
//import static com.tutego.jrtf.RtfDocfmt.*;
//import static com.tutego.jrtf.RtfHeader.*;
//import static com.tutego.jrtf.RtfInfo.*;
//import static com.tutego.jrtf.RtfFields.*;
//import static com.tutego.jrtf.RtfPara.*;
//import static com.tutego.jrtf.RtfSectionFormatAndHeaderFooter.*;
//import static com.tutego.jrtf.RtfText.*;
//import static com.tutego.jrtf.RtfUnit.*;

import static com.tutego.jrtf.Rtf.rtf;
import static com.tutego.jrtf.RtfHeader.font;
import static com.tutego.jrtf.RtfPara.*;
import static com.tutego.jrtf.RtfText.*;
import static com.tutego.jrtf.RtfUnit.CM;
import java.awt.Desktop;
import java.io.*;
import java.util.Date;
import com.tutego.jrtf.*;
//import com.tutego.jrtf.RtfPicture.PictureType;

/**
 * Example class.
 */
public class ExportRTF {

    /**
     * Starts application.
     *
     * @param args Program arguments.
     * @throws IOException If something goes wrong during writing.
     */
//<editor-fold defaultstate="collapsed" desc=" Tipos de FORMATAÇÂO de texto e paragrafo ">
//    tab(), bold(), italic(), underline()
//</editor-fold>
    public static void main(String... args) throws IOException {
        File out = new File("out.rtf");

//        RtfPara p1 = RtfPara.p(bold("primeiro paragrafo"));
//        RtfPara p2 = RtfPara.p("segundo paragrafo");
//        RtfPara p3 = RtfPara.p("terceiro paragrafo");
        // STRING para os textos
        String p1 = "primeiro paragrafo";

        rtf().
                //header da section 1
                header(
                        RtfHeader.font(RtfHeaderFont.COURIERPRIME).at(1),
                        RtfHeader.color(150, 150, 150).at(1)
                ).
                // section 1
                section(
                        // primeiro paragrafo
                        p(
                                RtfText.font(1, RtfText.fontSize(18, RtfText.color(1, p1))),
                                bold(RtfText.font(1, RtfText.fontSize(18, RtfText.color(1, "titulo improvisado"))))
                        ).spaceAfterLine(0.0, CM),
                        //segundo paragrafo
                        p(
                                tab(),
                                " third par ",
                                bold("with something in bold"),
                                text(" and "),
                                italic(underline("italic underline"))
                        ).spaceAfterLine(0.25, CM)
                ).
                //header da section 2
                header(
                        font(RtfHeaderFont.COURIERPRIME).at(1),
                        RtfHeader.color(150, 150, 150).at(1)
                ).
                // section 2: CORPO DE TEXTO
                section( //primeiro paragrafo
                //segundo paragrafo
                ).
                //section FOOTER
                section( // primeiro paragrafo
                ).out(new FileWriter(out));

        try {
            Desktop.getDesktop().open(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
