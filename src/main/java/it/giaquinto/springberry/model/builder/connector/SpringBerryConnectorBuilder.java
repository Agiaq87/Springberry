package it.giaquinto.springberry.model.builder.connector;

import it.giaquinto.springberry.model.builder.SpringBerryBuilder;
import it.giaquinto.springberry.model.builder.connector.exception.AsyncTimeNegativeException;
import it.giaquinto.springberry.model.constant.SpringBerryPort;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.apache.tomcat.util.buf.EncodedSolidusHandling;

// TODO
public final class SpringBerryConnectorBuilder implements SpringBerryBuilder {

    /**
     * A boolean value which can be used to enable or disable the TRACE HTTP method. If not specified,
     * this attribute is set to false.
     */
    private boolean allowTrace = false;

    /**
     * The default timeout for asynchronous requests in milliseconds. If not specified,
     * this attribute is set to the Servlet specification default of 30000 (30 seconds).
     */
    private long asyncTimeout = 30000; // 30 seconds

    /**
     * A boolean value which can be used to enable or disable the recycling of the facade objects that isolate the
     * container internal request processing objects. If set to true the facades will be set for garbage collection
     * after every request, otherwise they will be reused. This setting has no effect when the security manager is
     * enabled. If not specified, this attribute is set to the value of the
     * org.apache.catalina.connector.RECYCLE_FACADES system property, or false if not set.
     */
    private boolean discardFacades = true;

    /**
     * Set to true if you want calls to request.getRemoteHost() to perform DNS lookups in order to return the actual
     * host name of the remote client. Set to false to skip the DNS lookup and return the IP address in String form
     * instead (thereby improving performance). By default, DNS lookups are disabled.
     */
    private boolean enableLookups = false;

    /**
     * When set to reject request paths containing a %2f sequence will be rejected with a 400 response. When set
     * to decode request paths containing a %2f sequence will have that sequence decoded to / at the same time other %nn
     * sequences are decoded. When set to passthrough request paths containing a %2f sequence will be processed with
     * the %2f sequence unchanged. If not specified the default value is reject. This default may be modified if the
     * deprecated system property org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH is set.
     */
    private EncodedSolidusHandling encodedSolidusHandling = EncodedSolidusHandling.REJECT;
    private boolean enforceEncodingInGetWriter = true;
    private final String protocol = "AJP/1.3";
    private String scheme = "http";
    private boolean secretRequired = false;
    private boolean secure = false;
    private SpringBerryPort port = SpringBerryPort.DEFAULT;


    private final Connector ajpConnector;


    public SpringBerryConnectorBuilder() {
        ajpConnector = new Connector(protocol);
    }

    public SpringBerryConnectorBuilder(Connector ajpConnector) {
        this.ajpConnector = ajpConnector;
    }


    public SpringBerryConnectorBuilder setAllowTrace(final boolean allowTrace) {
        this.allowTrace = allowTrace;
        return this;
    }

    public SpringBerryConnectorBuilder setAsyncTimeout(final long asyncTimeout) throws AsyncTimeNegativeException {
        if (asyncTimeout < 0) {
            throw new AsyncTimeNegativeException();
        }

        this.asyncTimeout = asyncTimeout;
        return this;
    }

    public SpringBerryConnectorBuilder setEnableLookups(final boolean enableLookups) {
        this.enableLookups = enableLookups;
        return this;
    }

    public SpringBerryConnectorBuilder setEnforceEncodingInGetWriter(final boolean enforceEncodingInGetWriter) {
        this.enforceEncodingInGetWriter = enforceEncodingInGetWriter;
        return this;
    }

    public SpringBerryConnectorBuilder setDiscardFacades(final boolean discardFacades) {
        this.discardFacades = discardFacades;
        return this;
    }

    public SpringBerryConnectorBuilder setScheme(final String scheme) {
        this.scheme = scheme;
        return this;
    }

    public SpringBerryConnectorBuilder setSecure(final boolean secure) {
        this.secure = secure;
        return this;
    }


    public Connector build() {
        //TODO
        return ajpConnector;
    }

    public Connector defaultBuild() {
        ajpConnector.setAllowTrace(allowTrace);
        ajpConnector.setPort(port.getPortValue());
        ajpConnector.setScheme(scheme);
        ajpConnector.setSecure(secure);
        ((AbstractAjpProtocol<?>) ajpConnector.getProtocolHandler()).setSecretRequired(secretRequired);
        return ajpConnector;
    }
}
