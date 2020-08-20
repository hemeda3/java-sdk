package com.global.api.tests;

import com.global.api.utils.EmvData;
import com.global.api.utils.EmvUtils;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class EmvTests {
    @Test
    public void parseTagData() {
        String tagData = "4f07a0000000041010500a4d61737465724361726457135413330089010434d22122019882803290000f5a085413330089010434820238008407a00000000410108e0a00000000000000001f00950500008080009a031901099b02e8009c01405f201a546573742f4361726420313020202020202020202020202020205f24032212315f25030401015f2a0208405f300202015f3401009f01060000000000019f02060000000006009f03060000000000009f0607a00000000410109f0702ff009f090200029f0d05b8508000009f0e0500000000009f0f05b8708098009f10120110a0800f22000065c800000000000000ff9f120a4d6173746572436172649f160f3132333435363738393031323334359f1a0208409f1c0831313232333334349f1e0831323334353637389f21030710109f26080631450565a30b759f2701809f330360f0c89f34033f00019f3501219f360200049f3704c6b1a04f9f3901059f4005f000a0b0019f4104000000869f4c0865c862608a23945a9f4e0d54657374204d65726368616e74";

        EmvData emvData = EmvUtils.parseTagData(tagData, true);
        assertNull(emvData.getTag("57"));
        assertNull(emvData.getTag("5A"));
        assertNull(emvData.getTag("5F20"));
        assertNull(emvData.getTag("5F24"));
        //assertTrue(emvData.getAcceptedTagData().length() <= 512);
        assertFalse(emvData.isContactlessMsd());
    }

    @Test
    public void parseContactlessMsd() {
        String tagData = "4F08A0000000250104035010414D45524943414E20455850524553535F25031711015F280208265F2A0208405F300207025F340100820219008408A0000000250104038E0E000000000000000042015E031F02950500000000009A032001319B02E8009C01009F02060000000001199F03060000000000009F0606A000000025019F0702FF009F080200019F090200019F0D05F470C498009F0E0500000000009F0F05F470C498009F100706020203A000009F160F0000000000000000000000000000009F1A0208409F1C0800000000000000009F1E0831323334353637389F21031832199F26083521C82866B42F599F2701809F330360F8C89F34031F02029F3501229F360208019F3704000017069F3901919F40057000A0A0019F4104000014419F4C08B1888AD406AC78F89F5301FFFFC605DE50FC9800FFC7050010000000FFC805DE00FC9800563C423337343234353030313735313030365E585020434152442030332F56455220322E3020202030323034395E323431323730323137303630383630319F6D01C09F6E04D8E00000";

        EmvData emvData = EmvUtils.parseTagData(tagData, true);
        assertNull(emvData.getTag("57"));
        assertNull(emvData.getTag("5A"));
        assertNull(emvData.getTag("5F20"));
        assertNull(emvData.getTag("5F24"));
        //assertTrue(emvData.getAcceptedTagData().length() <= 512);
        assertTrue(emvData.isContactlessMsd());
    }

    @Test
    public void parseOfflinePin() {
        ArrayList<String> cvrs = new ArrayList<String>() {{
            add("9F3403010302");
            add("9F3403030302");
            add("9F3403040302");
            add("9F3403050302");
            add("9F3403410302");
            add("9F3403430302");
            add("9F3403440302");
            add("9F3403450302");
        }};

        for(String cvr: cvrs) {
            EmvData emvData = EmvUtils.parseTagData(cvr, true);
            assertTrue(emvData.isOfflinePin());
        }
    }
}
