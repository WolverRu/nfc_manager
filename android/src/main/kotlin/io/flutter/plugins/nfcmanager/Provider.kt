package io.flutter.plugins.nfcmanager

// import com.github.devnied.emvnfccard.parser.IProvider
import com.github.devnied.emvnfccard.parser.IProvider
import com.github.devnied.emvnfccard.parser.EmvTemplate
import com.github.devnied.emvnfccard.model.EmvCard
import com.github.devnied.emvnfccard.exception.CommunicationException
// import com.github.devnied.emvnfccard.exception.CommunicationException
// import com.github.devnied.emvnfccard.model.EmvCard
import android.nfc.tech.IsoDep
import java.io.IOException

class Provider : IProvider {
    private var mTagCom: IsoDep? = null

    @Throws(CommunicationException::class)
    override fun transceive(pCommand: ByteArray): ByteArray {
        val response: ByteArray = try {
            mTagCom!!.transceive(pCommand)
        } catch (e: IOException) {
            throw CommunicationException(e.message)
        }
        return response
    }

    override fun getAt(): ByteArray {
        return mTagCom!!.historicalBytes
    }

    fun setmTagCom(mTagCom: IsoDep?) {
        this.mTagCom = mTagCom
    }
}