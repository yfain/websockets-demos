package com.faratasystems.demos.websockets.encode;

import com.faratasystems.demos.common.domain.StockMessage;
import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;

/**
 * TODO
 *
 * @author Viktor Gamov (viktor.gamov@faratasystems.com)
 * @since 12/20/12
 */
public class StockMessageEncoderDecoder implements Encoder.Text<StockMessage>, Decoder.Text<StockMessage> {
    @Override
    public String encode(StockMessage object) throws EncodeException {
        return new Gson().toJson(object);
    }

    @Override
    public StockMessage decode(String s) throws DecodeException {
        Gson gson = new Gson();
        return gson.fromJson(s, StockMessage.class);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }
}
