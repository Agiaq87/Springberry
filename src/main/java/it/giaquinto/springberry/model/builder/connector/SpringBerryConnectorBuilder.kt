package it.giaquinto.springberry.model.builder.connector

import it.giaquinto.springberry.model.builder.SpringBerryBuilder
import it.giaquinto.springberry.model.builder.connector.exception.AsyncTimeNegativeException
import it.giaquinto.springberry.model.constant.SpringBerryPort
import org.apache.catalina.connector.Connector
import org.apache.coyote.ajp.AbstractAjpProtocol
import org.apache.tomcat.util.buf.EncodedSolidusHandling

// TODO
class SpringBerryConnectorBuilder : SpringBerryBuilder {
    /**
     * A boolean value which can be used to enable or disable the TRACE HTTP method. If not specified,
     * this attribute is set to false.
     */
    private var allowTrace = false

    /**
     * The default timeout for asynchronous requests in milliseconds. If not specified,
     * this attribute is set to the Servlet specification default of 30000 (30 seconds).
     */
    private var asyncTimeout: Long = 30000 // 30 seconds

    /**
     * A boolean value which can be used to enable or disable the recycling of the facade objects that isolate the
     * container internal request processing objects. If set to true the facades will be set for garbage collection
     * after every request, otherwise they will be reused. This setting has no effect when the security manager is
     * enabled. If not specified, this attribute is set to the value of the
     * org.apache.catalina.connector.RECYCLE_FACADES system property, or false if not set.
     */
    private var discardFacades = true

    /**
     * Set to true if you want calls to request.getRemoteHost() to perform DNS lookups in order to return the actual
     * host name of the remote client. Set to false to skip the DNS lookup and return the IP address in String form
     * instead (thereby improving performance). By default, DNS lookups are disabled.
     */
    private var enableLookups = false

    /**
     * When set to reject request paths containing a %2f sequence will be rejected with a 400 response. When set
     * to decode request paths containing a %2f sequence will have that sequence decoded to / at the same time other %nn
     * sequences are decoded. When set to passthrough request paths containing a %2f sequence will be processed with
     * the %2f sequence unchanged. If not specified the default value is reject. This default may be modified if the
     * deprecated system property org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH is set.
     */
    private val encodedSolidusHandling = EncodedSolidusHandling.REJECT
    private var enforceEncodingInGetWriter = true
    private val protocol = "AJP/1.3"
    private var scheme = "http"
    private val secretRequired = false
    private var secure = false
    private val port = SpringBerryPort.DEFAULT
    private val ajpConnector: Connector

    constructor() {
        ajpConnector = Connector(protocol)
    }

    constructor(ajpConnector: Connector) {
        this.ajpConnector = ajpConnector
    }

    fun setAllowTrace(allowTrace: Boolean): SpringBerryConnectorBuilder {
        this.allowTrace = allowTrace
        return this
    }

    @Throws(AsyncTimeNegativeException::class)
    fun setAsyncTimeout(asyncTimeout: Long): SpringBerryConnectorBuilder {
        if (asyncTimeout < 0) {
            throw AsyncTimeNegativeException()
        }
        this.asyncTimeout = asyncTimeout
        return this
    }

    fun setEnableLookups(enableLookups: Boolean): SpringBerryConnectorBuilder {
        this.enableLookups = enableLookups
        return this
    }

    fun setEnforceEncodingInGetWriter(enforceEncodingInGetWriter: Boolean): SpringBerryConnectorBuilder {
        this.enforceEncodingInGetWriter = enforceEncodingInGetWriter
        return this
    }

    fun setDiscardFacades(discardFacades: Boolean): SpringBerryConnectorBuilder {
        this.discardFacades = discardFacades
        return this
    }

    fun setScheme(scheme: String): SpringBerryConnectorBuilder {
        this.scheme = scheme
        return this
    }

    fun setSecure(secure: Boolean): SpringBerryConnectorBuilder {
        this.secure = secure
        return this
    }

    fun build(): Connector {
        //TODO
        return ajpConnector
    }

    fun defaultBuild(): Connector {
        ajpConnector.allowTrace = allowTrace
        ajpConnector.port = port.portValue
        ajpConnector.scheme = scheme
        ajpConnector.secure = secure
        (ajpConnector.protocolHandler as AbstractAjpProtocol<*>).secretRequired = secretRequired
        return ajpConnector
    }
}