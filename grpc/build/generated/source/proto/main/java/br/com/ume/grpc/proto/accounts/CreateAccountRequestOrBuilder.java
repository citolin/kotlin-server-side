// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: accounts.proto

package br.com.ume.grpc.proto.accounts;

public interface CreateAccountRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:accounts.CreateAccountRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string document = 3;</code>
   * @return The document.
   */
  java.lang.String getDocument();
  /**
   * <code>string document = 3;</code>
   * @return The bytes for document.
   */
  com.google.protobuf.ByteString
      getDocumentBytes();

  /**
   * <code>double value = 4;</code>
   * @return The value.
   */
  double getValue();
}
